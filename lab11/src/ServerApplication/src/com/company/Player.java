package com.example.demo;

@RestController
@RequestMapping("/players")
public class Player {

    private List<Player> playerNames = new ArrayList<>();
    private final int id = 0;
    public Player(String name) {
        int id = 1 + playerNames.size();
        playerNames.add(new Player(id, name));
    }

    @GetMapping
    public List<Player> getPlayerNames() {
        return playerNames;
    }

    @GetMapping("/count")
    public int countPlayerNames() {
        return playerNames.size();
    }

    @GetMapping("/{id}")
    public Product getPlayerNames(@PathVariable("id") int id) {
        return playerNames.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public int createProduct(@RequestParam String name) {
        int id = 1 + playerNames.size();
        playerNames.add(new Player(id, name));
        return id;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String> createPlayer(@RequestBody Player player) {
        playerNames.add(player);
        return new ResponseEntity<>(
                "Player adeed successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name) {
        Player player = findById(id);
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.NOT_FOUND); //or GONE
        }
        player.setName(name);
        return new ResponseEntity<>(
                "Player updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        Player player = findById(id);
        if (product == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.GONE);
        }
        playerNames.remove(player);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }
}
package com.plenilune.tacoapi;

import com.plenilune.tacodata.TacoRepository;
import com.plenilune.tacodata.TacoService;
import com.plenilune.tacodomain.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {

    private final TacoService tacoService;

    public DesignTacoController(TacoService tacoService) {
        this.tacoService = tacoService;
    }

    @GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
        return tacoService.recentTacos();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoService.save(taco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optionalTaco = tacoService.findById(id);

        return optionalTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

}

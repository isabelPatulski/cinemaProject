package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.dto.ShowingRequest;
import kea.sem3.jwtdemo.dto.ShowingResponse;
import kea.sem3.jwtdemo.service.ShowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/showings")
public class ShowingController {
    ShowingService showingService;

    public ShowingController(ShowingService showingService) {
        this.showingService = showingService;
    }

    @GetMapping
    public List<ShowingResponse> getAllShowings(){
        return showingService.getAllShowings();
    }

    @GetMapping("/{id}")
    public ShowingResponse getShowing(@PathVariable int id) throws Exception
    {
        return showingService.getShowing(id);
    }

    @PostMapping
    public ShowingResponse createShowing(@RequestBody ShowingRequest showingRequest){
        return showingService.createShowing(showingRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteShowing(@PathVariable int id){}
}

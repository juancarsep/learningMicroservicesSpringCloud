package jics.users.repository;

import jics.users.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//si el nombre coincide con el nombre de la aplicacion del servicio que consumimos, no debemos poner url gracias a Eureka.
@FeignClient(name = "post")
public interface IPostsApi {

    @GetMapping("/posts/getpostsbyuser/{userId}")
    public List<PostDTO> getPostsByUser(@PathVariable Long userId);
}

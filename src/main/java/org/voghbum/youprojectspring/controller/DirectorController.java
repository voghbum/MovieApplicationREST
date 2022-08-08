package org.voghbum.youprojectspring.controller;

import org.csystem.util.Console;
import com.voghbum.util.data.service.DataServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.voghbum.youprojectspring.dto.DirectorDTO;
import org.voghbum.youprojectspring.service.DirectorService;

import java.util.ArrayList;
import java.util.List;

@RestController @Scope("prototype")
@RequestMapping("api/director")
public class DirectorController {
    private final DirectorService m_directorService;

    public DirectorController(DirectorService directorService) {
        m_directorService = directorService;
    }

    @GetMapping("/directors")
    public List<DirectorDTO> findAllDirectors() {
        try {
            return m_directorService.findAllDirectors();

        } catch (DataServiceException ex) {
            Console.writeLine("%s%n%s", ex.getMessage(), ex.getCause());
            return new ArrayList<>();
        }
    }
}

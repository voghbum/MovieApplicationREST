package org.voghbum.youprojectspring.converter;

import org.springframework.stereotype.Component;
import org.voghbum.youprojectspring.data.entity.Director;
import org.voghbum.youprojectspring.dto.DirectorDTO;

@Component
public class DirectorConverter {
    public DirectorDTO toDirectorDTO(Director director) {
        var directorDTO = new DirectorDTO();

        directorDTO.setBirthDate(director.getBirthDate());
        directorDTO.setName(director.getName());

        return directorDTO;
    }

    public Director toDirector(DirectorDTO directorDTO) {
        var director = new Director();

        director.setBirthDate(directorDTO.getBirthDate());
        director.setName(directorDTO.getName());

        return director;
    }
}

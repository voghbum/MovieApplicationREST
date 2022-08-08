package org.voghbum.youprojectspring.service;

import com.voghbum.util.data.repository.RepositoryException;
import com.voghbum.util.data.service.DataServiceException;
import org.springframework.stereotype.Service;
import org.voghbum.youprojectspring.converter.DirectorConverter;
import org.voghbum.youprojectspring.data.dal.MovieServiceApplicationDAL;
import org.voghbum.youprojectspring.dto.DirectorDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class DirectorService {
    private final DirectorConverter m_directorConverter;
    private final MovieServiceApplicationDAL m_movieServiceApplicationDAL;

    public DirectorService(DirectorConverter directorConverter, MovieServiceApplicationDAL movieServiceApplicationDAL) {
        m_directorConverter = directorConverter;
        m_movieServiceApplicationDAL = movieServiceApplicationDAL;
    }

    public List<DirectorDTO> findAllDirectors() {
        try {
            return StreamSupport.stream(m_movieServiceApplicationDAL.findAllDirectors().spliterator(), false)
                    .map(m_directorConverter::toDirectorDTO)
                    .collect(Collectors.toList());
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.findAllDirectors", ex.getCause());
        }

    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO) {
        try {
            m_movieServiceApplicationDAL.saveDirector(m_directorConverter.toDirector(directorDTO));

            return directorDTO;
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.saveDirector", ex.getCause());
        }
    }
}

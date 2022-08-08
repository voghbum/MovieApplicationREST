package org.voghbum.youprojectspring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.voghbum.youprojectspring.data.entity.Director;

public interface IDirectorRepository extends CrudRepository<Director, Long> {
}

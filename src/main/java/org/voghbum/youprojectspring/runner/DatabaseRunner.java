package org.voghbum.youprojectspring.runner;

import org.csystem.util.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.voghbum.youprojectspring.data.repository.IMovieRepository;

//@Component
public class DatabaseRunner implements ApplicationRunner {
    private final IMovieRepository m_movieRepository;

    public DatabaseRunner(IMovieRepository movieRepository) {
        m_movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*Movie movie = new Movie();

        movie.setName("Inception");
        movie.setSceneTime(LocalDate.now());
        movie.setRating(100000);
        movie.setCost(new BigDecimal("100000000000"));
        movie.setImdb(7.5F);

        m_movieRepository.save(movie);
        Console.writeLine("id: %d", movie.getId());
        Console.writeLine("count: %d", m_movieRepository.count());*/

        var iter = m_movieRepository.findAll();
        iter.forEach(Console::writeLine);
    }
}

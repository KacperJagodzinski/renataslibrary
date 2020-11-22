package org.jagodzinskikacper.renataslibrary.lend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendRepository extends JpaRepository<Lend,Long> {
}

package ru.tigran.cardcollector.database.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tigran.cardcollector.database.entity.Sticker;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface StickerRepository extends CrudRepository<Sticker, String> {
    @Query(value = "select s from stickers s where s.PackId = ?1 order by s.Tier")
    ArrayList<Sticker> findByPackId(int packId);

    @Query(value = "select s from stickers s where s.MD5Hash = ?1")
    Sticker findByHash(String md5hash);

    @Override
    ArrayList<Sticker> findAll();
}
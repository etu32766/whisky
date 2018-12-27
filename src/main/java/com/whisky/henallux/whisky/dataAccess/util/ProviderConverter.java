package com.whisky.henallux.whisky.dataAccess.util;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import com.whisky.henallux.whisky.model.User;
import com.whisky.henallux.whisky.model.Whisky;
import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    //METHODE POUR CONVERTIR UN OBJET DE TYPE USERENTITY EN OBJET DE TYPE USER
    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAdresse(user.getAdresse());
        userEntity.setAuthorities(user.getAuthorities());
        userEntity.setCredentialsNonExpired(user.isCredentials_non_expired());
        userEntity.setEmail(user.getEmail());
        userEntity.setEnabled(user.isEnabled());
        userEntity.setLastname(user.getLastname());
        userEntity.setAccountNonExpired(user.isNon_expired());
        userEntity.setAccountNonLocked(user.isNon_locked());
        userEntity.setNumberTVA(user.getNumberTVA());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.setFirstname(user.getFirstname());
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity)
    {
        User user = new User();
        user.setAdresse(userEntity.getAdresse());
        user.setAuthorities(userEntity.getAuthorities());
        user.setCredentials_non_expired(userEntity.isCredentialsNonExpired());
        user.setEmail(userEntity.getEmail());
        user.setEnabled(userEntity.getEnabled());
        user.setFirstname(userEntity.getLastname());
        user.setLastname(userEntity.getLastname());
        user.setNon_expired(userEntity.getAccountNonExpired());
        user.setNon_locked(userEntity.getAccountNonLocked());
        user.setNumberTVA(userEntity.getNumberTVA());
        user.setPassword(userEntity.getPassword());
        user.setUsername(userEntity.getUsername());
        user.setConfPassword(userEntity.getPassword());
        return user;
    }

    /*public WhiskyEntity whiskyToWhiskyEntity(Whisky whisky){
        WhiskyEntity whiskyEntity = new WhiskyEntity();
        whiskyEntity.setAge(whisky.getAge());
        whiskyEntity.setAlcoholContent(whisky.getAlcoholContent());
        whiskyEntity.setBrand(whisky.getBrand());
        whiskyEntity.setCategorie(this.categorieToCategorieEntity(whisky.getCategorie()));
        whiskyEntity.setCountry(whisky.getCountry());
        whiskyEntity.setWhiskyName(whisky.getWhiskyName());
        whiskyEntity.setId(whisky.getId());
        whiskyEntity.setImg(whisky.getImg());
        whiskyEntity.setPrice(whisky.getPrice());
        whiskyEntity.setProductionDate(whisky.getProductionDate());
        whiskyEntity.setPromotion(whisky.getPromotion());
        whiskyEntity.setRegion(whisky.getRegion());
        whiskyEntity.setSelection(whisky.getSelection());
        whiskyEntity.setStockQuantity(whisky.getStockQuantity());
        whiskyEntity.setVolume(whisky.getVolume());
        return whiskyEntity;
    }

    public Whisky whiskyEntityToWhisky(WhiskyEntity whiskyEntity){
        Whisky whisky = new Whisky();
        whisky.setBrand(whiskyEntity.getBrand());
        whisky.setAge(whiskyEntity.getAge());
        whisky.setAlcoholContent(whiskyEntity.getAlcoholContent());
        whisky.setCountry(whiskyEntity.getCountry());
        whisky.setId(whiskyEntity.getId());
        whisky.setImg(whiskyEntity.getImg());
        whisky.setPrice(whiskyEntity.getPrice());
        whisky.setProductionDate(whiskyEntity.getProductionDate());
        whisky.setPromotion(whiskyEntity.getPromotion());
        whisky.setCategorie(this.categorieEntityToCategorie(whiskyEntity.getCategorie()));
        whisky.setRegion(whiskyEntity.getRegion());
        whisky.setStockQuantity(whiskyEntity.getStockQuantity());
        whisky.setSelection(whiskyEntity.getSelection());
        whisky.setVolume(whiskyEntity.getVolume());
        whisky.setWhiskyName(whiskyEntity.getWhiskyName());
        return whisky;
    }

    public CategorieEntity categorieToCategorieEntity(Categorie categorie){
        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setNom(categorie.getCategorie());
        return categorieEntity;
    }

    public Categorie categorieEntityToCategorie(CategorieEntity categorieEntity){
        Categorie categorie = new Categorie();
        categorie.setCategorie(categorieEntity.getNom());
        return categorie;
    }*/


    public WhiskyEntity whiskyToWhiskyEntity(Whisky whisky)
    {
        return mapper.map(whisky, WhiskyEntity.class);
    }

    public Whisky whiskyEntityToWhisky(WhiskyEntity whiskyEntity)
    {
        return mapper.map(whiskyEntity, Whisky.class);
    }




}

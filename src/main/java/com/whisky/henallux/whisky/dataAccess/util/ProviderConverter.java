package com.whisky.henallux.whisky.dataAccess.util;

import com.whisky.henallux.whisky.dataAccess.entity.*;
import com.whisky.henallux.whisky.model.*;
import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {
    //private Mapper mapper = new DozerBeanMapper();

    //METHODE POUR CONVERTIR UN OBJET DE TYPE USERENTITY EN OBJET DE TYPE USER
    /*public UserEntity userModelToUserEntity(User user) { return mapper.map(user, UserEntity.class); }
    public User userEntityToUserModel(UserEntity userEntity) { return  mapper.map(userEntity, User.class); }*/
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
        userEntity.setTelephone(user.getTelephone());
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
        user.setEnabled(userEntity.isEnabled());
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());
        user.setNon_expired(userEntity.isAccountNonExpired());
        user.setNon_locked(userEntity.isAccountNonLocked());
        user.setTelephone(userEntity.getTelephone());
        user.setPassword(userEntity.getPassword());
        user.setUsername(userEntity.getUsername());
        user.setConfPassword(userEntity.getPassword());
        return user;
    }

    /*public WhiskyEntity whiskyToWhiskyEntity(Whisky whisky) { return mapper.map(whisky, WhiskyEntity.class); }
    public Whisky whiskyEntityToWhisky(WhiskyEntity whiskyEntity) { return mapper.map(whiskyEntity, Whisky.class); }*/
    public WhiskyEntity whiskyToWhiskyEntity(Whisky whisky)
    {
        WhiskyEntity whiskyEntity = new WhiskyEntity();
        whiskyEntity.setId(whisky.getId());
        whiskyEntity.setWhiskyName(whisky.getWhiskyName());
        whiskyEntity.setAge(whisky.getAge());
        whiskyEntity.setSelection(whisky.getSelection());
        whiskyEntity.setBrand(whisky.getBrand());
        whiskyEntity.setRegion(whisky.getRegion());
        whiskyEntity.setCountry(whisky.getCountry());
        whiskyEntity.setProductionDate(whisky.getProductionDate());
        whiskyEntity.setAlcoholContent(whisky.getAlcoholContent());
        whiskyEntity.setVolume(whisky.getVolume());
        whiskyEntity.setStockQuantity(whisky.getStockQuantity());
        whiskyEntity.setCategorie(whisky.getCategorie());
        whiskyEntity.setImg(whisky.getImg());
        whiskyEntity.setPrice(whisky.getPrice());
        whiskyEntity.setPromotion(whisky.getPromotion());
        return whiskyEntity;
    }
    public Whisky whiskyEntityToWhisky(WhiskyEntity whiskyEntity)
    {
        Whisky whisky = new Whisky();
        whisky.setId(whiskyEntity.getId());
        whisky.setWhiskyName(whiskyEntity.getWhiskyName());
        whisky.setAge(whiskyEntity.getAge());
        whisky.setSelection(whiskyEntity.getSelection());
        whisky.setBrand(whiskyEntity.getBrand());
        whisky.setRegion(whiskyEntity.getRegion());
        whisky.setCountry(whiskyEntity.getCountry());
        whisky.setProductionDate(whiskyEntity.getProductionDate());
        whisky.setAlcoholContent(whiskyEntity.getAlcoholContent());
        whisky.setVolume(whiskyEntity.getVolume());
        whisky.setStockQuantity(whiskyEntity.getStockQuantity());
        whisky.setCategorie(whiskyEntity.getCategorie());
        whisky.setImg(whiskyEntity.getImg());
        whisky.setPrice(whiskyEntity.getPrice());
        whisky.setPromotion(whiskyEntity.getPromotion());
        return whisky;
    }

    /*public CommandLineEntity commandLineToCommandLineEntity(CommandLine commandLine) { return mapper.map(commandLine, CommandLineEntity.class); }
    public CommandLine commandLineEntityToCommandLine(CommandLineEntity commandLineEntity) { return mapper.map(commandLineEntity, CommandLine.class); }*/
    public CommandLineEntity commandLineToCommandLineEntity(CommandLine commandLine)
    {
        CommandLineEntity commandLineEntity = new CommandLineEntity();
        commandLineEntity.setId(commandLine.getId());
        commandLineEntity.setRealprice(commandLine.getRealPrice());
        commandLineEntity.setQuantity(commandLine.getQuantity());
        commandLineEntity.setWhiskyorder(commandLine.getWhiskyOrder());
        commandLineEntity.setWhisky(commandLine.getWhisky());
        return  commandLineEntity;
    }
    public CommandLine commandLineEntityToCommandLine(CommandLineEntity commandLineEntity)
    {
        CommandLine commandLine = new CommandLine();
        commandLine.setId(commandLineEntity.getId());
        commandLine.setRealPrice(commandLineEntity.getRealprice());
        commandLine.setQuantity(commandLineEntity.getQuantity());
        commandLine.setWhiskyOrder(commandLineEntity.getWhiskyorder());
        commandLine.setWhisky(commandLineEntity.getWhisky());
        return commandLine;
    }

    /*public OrderEntity orderToOrderEntity(Order order) { return mapper.map(order, OrderEntity.class); }
    public Order orderEntityToOrder(OrderEntity orderEntity) { return mapper.map(orderEntity, Order.class); }*/
    public OrderEntity orderToOrderEntity(Order order)
    {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setDateOrder(order.getDateOrder());
        orderEntity.setValidity(order.isValidity());
        orderEntity.setUtilisateur(order.getUtilisateur());
        orderEntity.setPromotion(order.getPromotion());
        orderEntity.setTotalPrice(order.getTotalPrice());
        return orderEntity;
    }
    public Order orderEntityToOrder(OrderEntity orderEntity)
    {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setDateOrder(orderEntity.getDateOrder());
        order.setValidity(orderEntity.isValidity());
        order.setUtilisateur(orderEntity.getUtilisateur());
        order.setPromotion(orderEntity.getPromotion());
        order.setTotalPrice(orderEntity.getTotalPrice());
        return order;
    }

    public TranslationEntity translationToTranslationEntity(Translation translation)
    {
        TranslationEntity translationEntity = new TranslationEntity();
        translationEntity.setId(translation.getId());
        translationEntity.setDescriptions(translation.getDescriptions());
        translationEntity.setWhiskyid(translation.getWhiskyid());
        translationEntity.setLanguageid(translation.getLanguageid());
        return translationEntity;
    }
    public Translation translationEntityToTranslation(TranslationEntity translationEntity)
    {
        Translation translation = new Translation();
        translation.setId(translationEntity.getId());
        translation.setDescriptions(translationEntity.getDescriptions());
        translation.setWhiskyid(translationEntity.getWhiskyid());
        translation.setLanguageid(translationEntity.getLanguageid());
        return translation;
    }

    public LanguageEntity languageToLanguageEntity(Language language)
    {
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setId(language.getId());
        return languageEntity;
    }
    public Language languageEntityToLanguage(LanguageEntity languageEntity)
    {
        Language language = new Language();
        language.setId(languageEntity.getId());
        return language;
    }

    public CategorieEntity categorieToCategorieEntity(Categorie categorie)
    {
        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setNom(categorie.getNom());
        return categorieEntity;
    }
    public Categorie categorieEntityToCategorie(CategorieEntity categorieEntity)
    {
        Categorie categorie = new Categorie();
        categorie.setNom(categorieEntity.getNom());
        return categorie;
    }


}

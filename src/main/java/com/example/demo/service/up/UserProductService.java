package com.example.demo.service.up;

import com.example.demo.exceptions.DuplicateProductUserException;
import com.example.demo.model.User;
import com.example.demo.model.UserProduct;
import com.example.demo.model.UserProductDto;
import com.example.demo.repo.UserProductRepository;
import com.example.demo.repo.ResellerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserProductService {

    private static final Logger LOGGER = LogManager.getLogger(UserProductService.class);

    @Autowired
    UserProductRepository userProductRepository;
    @Autowired
    ResellerRepository resellerRepository;

    @Autowired
    ModelMapper modelMapper;


    public UserProductDto defineCommission(UserProductDto userProductDto) throws DuplicateProductUserException {
        LOGGER.info("Start defineCommission method for " + userProductDto.getCode());
        try{
            UserProduct userProduct = convertDtoToUserProduct(userProductDto);
            UserProduct savedUserProduct = userProductRepository.save(userProduct);
            LOGGER.debug("Start find user ..");
            User user = resellerRepository.findByCode(userProduct.getResellerUser().getCode());
            UserProductDto u =  convertToUserLocationDTO(savedUserProduct);
            u.setUserName(user.getUserName());
            return u;

        }catch (DataIntegrityViolationException e){
            LOGGER.error(e.getMessage());
            throw new DuplicateProductUserException("Duplicate Data (userId,productId) !!!");
        }


    }

    private UserProductDto convertToUserLocationDTO(UserProduct user) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserProductDto userProductDto = modelMapper
                .map(user, UserProductDto.class);
        return userProductDto;
    }
    private UserProduct convertDtoToUserProduct(UserProductDto user) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserProduct userProduct = modelMapper
                .map(user, UserProduct.class);
        return userProduct;
    }

}

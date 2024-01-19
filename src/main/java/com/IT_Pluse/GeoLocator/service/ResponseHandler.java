package com.IT_Pluse.GeoLocator.service;



import Dto.GeneralListResponse;
import Dto.GeneralResponse;
import Dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ResponseHandler {

    @Value("${return.error.messages}")
    private Boolean viewErrors;

    @Autowired
    private MessageSource messageSource;



    private MessageDto getMessage(String message, Object[] args, Locale locale){

        int code = -2000;
        try{
            if(!viewErrors){
                code = Integer.parseInt(messageSource.getMessage(message+".code",null, locale));
                message = messageSource.getMessage(message,args, locale);
            }
        }catch (Exception e){
            code = Integer.parseInt(messageSource.getMessage("general.message.code",null,locale));
            message = messageSource.getMessage("general.message",new Object[]{},locale);
        }

        return new MessageDto(code,message);
    }

    public ResponseEntity<GeneralResponse> success(Object data, Object[] args, Locale locale){
        MessageDto msg = getMessage("operation.success",args,locale);
        return new GeneralResponse().response(msg.getCode(),
                msg.getMessage(),
                data
        );
    }



    public ResponseEntity<GeneralResponse> create(Object data){
        MessageDto msg = getMessage("operation.success",new Object[]{},LocaleContextHolder.getLocale());
        return new GeneralResponse().response(msg.getCode(),
                msg.getMessage(),
                data
        );
    }

    public ResponseEntity<GeneralResponse> successList(List data){
        MessageDto msg = getMessage("operation.success",new Object[]{},LocaleContextHolder.getLocale());
        return new GeneralResponse().response(data.size(),
                msg.getCode(),
                msg.getMessage(),
                data
        );
    }



    public ResponseEntity<GeneralResponse> success(Object data){
        MessageDto msg = getMessage("operation.success",new Object[]{},LocaleContextHolder.getLocale());
        return new GeneralResponse().response(msg.getCode(),
                msg.getMessage(),
                data
        );
    }

    public ResponseEntity<GeneralResponse> success(Object data,HttpStatus status){
        MessageDto msg = getMessage("operation.success",new Object[]{},LocaleContextHolder.getLocale());
        return new GeneralResponse().response(msg.getCode(),
                msg.getMessage(),
                data,
                status
        );
    }

    public ResponseEntity<GeneralResponse> success(String message, Object data,Object[] args){
        MessageDto msg = getMessage(message,args,LocaleContextHolder.getLocale());
        return new GeneralResponse().response(msg.getCode(),
                msg.getMessage(),
                data
        );
    }

    public ResponseEntity<GeneralResponse> success(String message,Object[] args){
        MessageDto msg = getMessage(message,args,LocaleContextHolder.getLocale());
        return new GeneralResponse().response(msg.getCode(),
                msg.getMessage(),
                new Object()
        );
    }

    public ResponseEntity<GeneralResponse> badRequest(String message,Object[] args){
        MessageDto msg = getMessage(message,args,LocaleContextHolder.getLocale());
        return new GeneralResponse().response(msg.getCode(),
                msg.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }



    public ResponseEntity<GeneralListResponse> successList(List data,Object[] args){
        MessageDto msg = getMessage("operation.success",args,LocaleContextHolder.getLocale());
        return new GeneralListResponse().response(msg.getCode(),
                msg.getMessage(),
                data.size(),
                1,
                1,
                data.size(),
                data
                );
    }

    public ResponseEntity<GeneralListResponse> successList(String message,List data,Object[] args){
        MessageDto msg = getMessage(message,args,LocaleContextHolder.getLocale());
        return new GeneralListResponse().response(msg.getCode(),
                msg.getMessage(),
                data.size(),
                1,
                1,
                data.size(),
                data
        );
    }

    public ResponseEntity<GeneralListResponse> successList(Page page, List data,Object[] args){
        MessageDto msg = getMessage("operation.success",args,LocaleContextHolder.getLocale());
        return new GeneralListResponse().response(msg.getCode(),
                msg.getMessage(),
                Integer.parseInt(page.getTotalElements()+""),
                page.getTotalPages(),
                page.getNumber()+1,
                page.getSize(),
                data
        );
    }

    public ResponseEntity<GeneralListResponse> successList(Page page,Object[] args){
        MessageDto msg = getMessage("operation.success",args,LocaleContextHolder.getLocale());
        return new GeneralListResponse().response(msg.getCode(),
                msg.getMessage(),
                Integer.parseInt(page.getTotalElements()+""),
                page.getTotalPages(),
                page.getNumber()+1,
                page.getSize(),
                page.stream().toList()
        );
    }

    public ResponseEntity<GeneralListResponse> successList(String message, Page page, List data, Object[] args){
        MessageDto msg = getMessage(message,args,LocaleContextHolder.getLocale());
        return new GeneralListResponse().response(msg.getCode(),
                msg.getMessage(),
                Integer.parseInt(page.getTotalElements()+""),
                page.getTotalPages(),
                page.getNumber()+1,
                page.getSize(),
                data
        );
    }

    public ResponseEntity<GeneralListResponse> listBadRequest(String message,Object[] args){
        MessageDto msg = getMessage(message,args,LocaleContextHolder.getLocale());
        return new GeneralListResponse().response(msg.getCode(),
                msg.getMessage(),
                0,
                0,
                1,
                1,
                new ArrayList<>()
        );
    }




}

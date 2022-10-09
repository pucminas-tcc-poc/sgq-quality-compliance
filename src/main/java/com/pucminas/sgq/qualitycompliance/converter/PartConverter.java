package com.pucminas.sgq.qualitycompliance.converter;

import com.pucminas.sgq.qualitycompliance.domain.PartEntity;
import com.pucminas.sgq.qualitycompliance.vo.PartVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class PartConverter {

    @Autowired
    private static ModelMapper modelMapper;

    public static PartEntity toEntity(PartVO partVO) throws ParseException {
        return modelMapper.map(partVO, PartEntity.class);
    }

    public static PartVO toVO(PartEntity partEntity) {
        return modelMapper.map(partEntity, PartVO.class);
    }
}

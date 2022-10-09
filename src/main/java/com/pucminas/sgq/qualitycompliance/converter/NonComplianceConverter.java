package com.pucminas.sgq.qualitycompliance.converter;

import com.pucminas.sgq.qualitycompliance.domain.NonComplianceEntity;
import com.pucminas.sgq.qualitycompliance.vo.NonComplianceVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class NonComplianceConverter {

    @Autowired
    private static ModelMapper modelMapper;

    public static NonComplianceEntity toEntity(NonComplianceVO nonComplianceVO) throws ParseException {
        return modelMapper.map(nonComplianceVO, NonComplianceEntity.class);
    }

    public static NonComplianceVO toVO(NonComplianceEntity nonComplianceEntity) {
        return modelMapper.map(nonComplianceEntity, NonComplianceVO.class);
    }
}

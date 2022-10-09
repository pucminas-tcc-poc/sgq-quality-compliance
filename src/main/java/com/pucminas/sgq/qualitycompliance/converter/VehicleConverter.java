package com.pucminas.sgq.qualitycompliance.converter;

import com.pucminas.sgq.qualitycompliance.domain.VehicleEntity;
import com.pucminas.sgq.qualitycompliance.vo.VehicleVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class VehicleConverter {

    @Autowired
    private static ModelMapper modelMapper;

    public static VehicleEntity toEntity(VehicleVO vehicleVO) throws ParseException {
        return modelMapper.map(vehicleVO, VehicleEntity.class);
    }

    public static VehicleVO toVO(VehicleEntity vehicleEntity) {
        return modelMapper.map(vehicleEntity, VehicleVO.class);
    }
}

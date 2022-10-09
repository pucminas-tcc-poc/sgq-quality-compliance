package com.pucminas.sgq.qualitycompliance.converter;

import com.pucminas.sgq.qualitycompliance.domain.IncidentEntity;
import com.pucminas.sgq.qualitycompliance.vo.IncidentVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class IncidentConverter {

    @Autowired
    private static ModelMapper modelMapper;

    public static IncidentEntity toEntity(IncidentVO incidentVO) throws ParseException {
        return modelMapper.map(incidentVO, IncidentEntity.class);
    }

    public static IncidentVO toVO(IncidentEntity incidentEntity) {
        return modelMapper.map(incidentEntity, IncidentVO.class);
    }
}

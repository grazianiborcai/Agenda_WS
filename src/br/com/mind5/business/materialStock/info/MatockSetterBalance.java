package br.com.mind5.business.materialStock.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.MatmovType;

public final class MatockSetterBalance extends InfoSetterTemplate<MatockInfo> {
	
	@Override protected MatockInfo setAttrHook(MatockInfo recordInfo) {
		int sign = MatmovType.getMatmovType(recordInfo.codMatmovType).getMathSign();
		int quantity = recordInfo.quantityToUpdate * sign;
		
		recordInfo.quantityStock = recordInfo.quantityStock + quantity;
		return recordInfo;
	}
}

package br.com.mind5.business.materialStock.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.MatmovType;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatockSetterBalance implements InfoSetter<MatockInfo> {
	
	public MatockInfo setAttr(MatockInfo recordInfo) {
		checkArgument(recordInfo);
		return setBalance(recordInfo);
	}
	
	
	
	private void checkArgument(MatockInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		MatmovType.getMatmovType(recordInfo.codMatmovType);
	}
	
	
	
	private MatockInfo setBalance(MatockInfo recordInfo) {
		int sign = MatmovType.getMatmovType(recordInfo.codMatmovType).getMathSign();
		int quantity = recordInfo.quantityToUpdate * sign;
		
		recordInfo.quantityStock = recordInfo.quantityStock + quantity;
		return recordInfo;
	}
	
	
	
	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}

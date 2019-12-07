package br.com.mind5.business.materialSearch.info;

import java.text.Normalizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatarchSetterTxtSearch implements InfoSetter<MatarchInfo> {
	
	public MatarchInfo setAttr(MatarchInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(MatarchInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatarchInfo setCodEntityCateg(MatarchInfo recordInfo) {
		if (recordInfo.txtMat == null)
			return recordInfo;
		
		
		recordInfo.txtMatSearch = recordInfo.txtMat.toUpperCase();
		recordInfo.txtMatSearch = Normalizer.normalize(recordInfo.txtMatSearch, Normalizer.Form.NFD);
		recordInfo.txtMatSearch = recordInfo.txtMatSearch.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}

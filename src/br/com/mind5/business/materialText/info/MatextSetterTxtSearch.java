package br.com.mind5.business.materialText.info;

import java.text.Normalizer;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatextSetterTxtSearch implements InfoSetter<MatextInfo> {
	
	public MatextInfo setAttr(MatextInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(MatextInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatextInfo setCodEntityCateg(MatextInfo recordInfo) {
		if (recordInfo.txtMat == null)
			return recordInfo;
		
		
		recordInfo.txtMatSearch = recordInfo.txtMat.toUpperCase();
		recordInfo.txtMatSearch = Normalizer.normalize(recordInfo.txtMatSearch, Normalizer.Form.NFD);
		recordInfo.txtMatSearch = recordInfo.txtMatSearch.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}

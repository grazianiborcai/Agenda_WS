package br.com.mind5.business.materialMovement.info;

import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatmovSetterPostingDate implements InfoSetter<MatmovInfo> {
	
	public MatmovInfo setAttr(MatmovInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.postingDate = genPostingDate();
		return recordInfo;
	}
	
	
	
	private void checkArgument(MatmovInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private LocalDate genPostingDate() {
		return DefaultValue.localDateNow();
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}

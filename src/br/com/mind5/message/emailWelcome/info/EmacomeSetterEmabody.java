package br.com.mind5.message.emailWelcome.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmacomeSetterEmabody implements InfoSetter<EmacomeInfo> {
	
	public EmacomeInfo setAttr(EmacomeInfo recordInfo) {
		checkArgument(recordInfo);
		return setEmabody(recordInfo);
	}
	
	
	
	private void checkArgument(EmacomeInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmacomeInfo setEmabody(EmacomeInfo recordInfo) {
		EmacomeInfo result = makeClone(recordInfo);		
		
		result.bodyData = new EmabodyInfo();
		
		result.recipientAddr = recordInfo.personData.email;
		result.bodyData.codLanguage = recordInfo.codLanguage;		
		result.bodyData.username = recordInfo.username;			
		result.bodyData.param01 = recordInfo.personData.name;
		result.bodyData.param02 = recordInfo.password;
		result.bodyData.param03 = recordInfo.username;
		result.bodyData.param04 = recordInfo.ownelisData.codOwner + " - " + recordInfo.ownelisData.complisData.name;
		
		return result;
	}
	
	
	
	private EmacomeInfo makeClone(EmacomeInfo recordInfo) {
		try {
			return (EmacomeInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}

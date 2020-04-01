package br.com.mind5.message.emailBody.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmabodySetterBody implements InfoSetter<EmabodyInfo> {
	
	public EmabodyInfo setAttr(EmabodyInfo recordInfo) {
		checkArgument(recordInfo);
		return replaceParam(recordInfo);
	}
	
	
	
	private void checkArgument(EmabodyInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmabodyInfo replaceParam(EmabodyInfo recordInfo) {
		EmabodyInfo result = makeClone(recordInfo);
		
		if(recordInfo.param01 != null)
			result.txtbody = result.txtbody.replace("&&PARAM_01&&", recordInfo.param01);
		
		if(recordInfo.param02 != null)
			result.txtbody = result.txtbody.replace("&&PARAM_02&&", recordInfo.param02);
		
		if(recordInfo.param03 != null)
			result.txtbody = result.txtbody.replace("&&PARAM_03&&", recordInfo.param03);
		
		if(recordInfo.param04 != null)
			result.txtbody = result.txtbody.replace("&&PARAM_04&&", recordInfo.param04);
		
		if(recordInfo.param05 != null)
			result.txtbody = result.txtbody.replace("&&PARAM_05&&", recordInfo.param05);
		
		return result;
	}
	
	
	
	private EmabodyInfo makeClone(EmabodyInfo recordInfo) {
		try {
			return (EmabodyInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}

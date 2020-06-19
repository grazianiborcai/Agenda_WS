package br.com.mind5.message.emailBody.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmabodySetterBody extends InfoSetterTemplate<EmabodyInfo> {
	
	@Override protected EmabodyInfo setAttrHook(EmabodyInfo recordInfo) {	
		if(recordInfo.param01 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_01&&", recordInfo.param01);
		
		if(recordInfo.param02 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_02&&", recordInfo.param02);
		
		if(recordInfo.param03 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_03&&", recordInfo.param03);
		
		if(recordInfo.param04 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_04&&", recordInfo.param04);
		
		if(recordInfo.param05 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_05&&", recordInfo.param05);
		
		if(recordInfo.param06 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_06&&", recordInfo.param06);
		
		if(recordInfo.param07 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_07&&", recordInfo.param07);
		
		if(recordInfo.param08 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_08&&", recordInfo.param08);
		
		if(recordInfo.param09 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_09&&", recordInfo.param09);
		
		if(recordInfo.param10 != null)
			recordInfo.txtbody = recordInfo.txtbody.replace("&&PARAM_10&&", recordInfo.param10);
		
		return recordInfo;
	}
}

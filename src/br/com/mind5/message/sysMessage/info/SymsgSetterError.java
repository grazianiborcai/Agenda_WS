package br.com.mind5.message.sysMessage.info;

import br.com.mind5.common.SystemCode;
import br.com.mind5.info.InfoSetterTemplate;

public final class SymsgSetterError extends InfoSetterTemplate<SymsgInfo> {
	
	@Override protected SymsgInfo setAttrHook(SymsgInfo recordInfo) {
		recordInfo.codMsg = SystemCode.SYS_MESSAGE_NOT_FOUND;
		return recordInfo;
	}
}

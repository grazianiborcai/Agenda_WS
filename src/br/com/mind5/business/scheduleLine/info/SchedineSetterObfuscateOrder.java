package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterObfuscateOrder extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		recordInfo.codOrder = DefaultValue.number();
		recordInfo.codOrderItem = DefaultValue.number();
		return recordInfo;
	}	
}

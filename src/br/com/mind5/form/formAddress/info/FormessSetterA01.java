package br.com.mind5.form.formAddress.info;

import br.com.mind5.form.common.Form;
import br.com.mind5.info.InfoSetterTemplate;

public final class FormessSetterA01 extends InfoSetterTemplate<FormessInfo> {	
	
	@Override protected FormessInfo setAttrHook(FormessInfo recordInfo) {
		recordInfo.codForm = Form.A01.getCodForm();
		return recordInfo;
	}
}

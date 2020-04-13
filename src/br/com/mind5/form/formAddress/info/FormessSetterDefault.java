package br.com.mind5.form.formAddress.info;

import br.com.mind5.form.common.Form;
import br.com.mind5.info.InfoSetterTemplate;

public final class FormessSetterDefault extends InfoSetterTemplate<FormessInfo> {	
	
	@Override protected FormessInfo setAttrHook(FormessInfo recordInfo) {
		recordInfo.codForm = Form.A00.getCodForm();
		return recordInfo;
	}
}

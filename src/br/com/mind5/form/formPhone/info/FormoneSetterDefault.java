package br.com.mind5.form.formPhone.info;

import br.com.mind5.form.common.Form;
import br.com.mind5.info.InfoSetterTemplate;

public final class FormoneSetterDefault extends InfoSetterTemplate<FormoneInfo> {	
	
	@Override protected FormoneInfo setAttrHook(FormoneInfo recordInfo) {
		recordInfo.codForm = Form.T00.getCodForm();
		return recordInfo;
	}
}

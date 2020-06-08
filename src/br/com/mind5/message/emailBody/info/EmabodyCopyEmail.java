package br.com.mind5.message.emailBody.info;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.message.email.info.EmailInfo;

final class EmabodyCopyEmail extends InfoCopierTemplate<EmabodyInfo, EmailInfo> {
	
	public EmabodyCopyEmail() {
		super();
	} 
	
	
	
	@Override protected EmabodyInfo makeCopyHook(EmailInfo source) {
		return CloneUtil.cloneRecord(source.bodyData, this.getClass());
	}
}

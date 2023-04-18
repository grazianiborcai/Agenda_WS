package br.com.mind5.webhook.pagarmeHook.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PagookSetterUpperCase extends InfoSetterTemplate<PagookInfo> {
	
	@Override protected PagookInfo setAttrHook(PagookInfo recordInfo) {
		recordInfo = setEvent(recordInfo);
		recordInfo = setStatus(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private PagookInfo setEvent(PagookInfo recordInfo) {
		if(recordInfo.event == null)
			return recordInfo;
			
		recordInfo.event = recordInfo.event.toUpperCase();		
		return recordInfo;
	}
	
	
	
	private PagookInfo setStatus(PagookInfo recordInfo) {
		if(recordInfo.data == null)
			return recordInfo;
		
		if(recordInfo.data.status == null)
			return recordInfo;
			
		recordInfo.data.status = recordInfo.data.status.toUpperCase();		
		return recordInfo;
	}
}

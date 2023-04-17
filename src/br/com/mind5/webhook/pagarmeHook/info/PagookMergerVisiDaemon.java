package br.com.mind5.webhook.pagarmeHook.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class PagookMergerVisiDaemon extends InfoMergerVisitorTemplate<PagookInfo, UserInfo> {

	@Override public boolean shouldMerge(PagookInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PagookInfo> merge(PagookInfo baseInfo, UserInfo selectedInfo) {
		List<PagookInfo> results = new ArrayList<>();
		
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
}

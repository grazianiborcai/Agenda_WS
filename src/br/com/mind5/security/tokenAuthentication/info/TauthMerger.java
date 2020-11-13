package br.com.mind5.security.tokenAuthentication.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class TauthMerger {
	public static List<TauthInfo> mergeWithJwtoken(List<TauthInfo> baseInfos, List<JwtokenInfo> selectedInfos) {
		InfoMergerBuilder<TauthInfo, JwtokenInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TauthVisiMergeJwtoken());
		InfoMerger<TauthInfo, JwtokenInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<TauthInfo> mergeWithUsername(List<TauthInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<TauthInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TauthVisiMergeUsername());
		InfoMerger<TauthInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}

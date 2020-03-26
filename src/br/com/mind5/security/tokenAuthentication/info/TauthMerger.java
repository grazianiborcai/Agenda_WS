package br.com.mind5.security.tokenAuthentication.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class TauthMerger {
	public static List<TauthInfo> mergeWithJwtoken(List<TauthInfo> baseInfos, List<JwtokenInfo> selectedInfos) {
		InfoMergerBuilderV3<TauthInfo, JwtokenInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TauthVisiMergeJwtoken());
		InfoMergerV3<TauthInfo, JwtokenInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<TauthInfo> mergeWithUsername(List<TauthInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<TauthInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TauthVisiMergeUsername());
		InfoMergerV3<TauthInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}

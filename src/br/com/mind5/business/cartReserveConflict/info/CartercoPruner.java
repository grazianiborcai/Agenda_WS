package br.com.mind5.business.cartReserveConflict.info;

import java.util.List;

import br.com.mind5.info.InfoPruner;
import br.com.mind5.info.InfoPrunerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartercoPruner {	
	
	public static List<CartercoInfo> pruneWithUsername(List<CartercoInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoPrunerBuilder<CartercoInfo, UsernameInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartercoVisiPruneUsername());
		InfoPruner<CartercoInfo, UsernameInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
}

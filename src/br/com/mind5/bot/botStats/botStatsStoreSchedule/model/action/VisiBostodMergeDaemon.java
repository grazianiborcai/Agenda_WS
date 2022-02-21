package br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserSelectDaemon;

final class VisiBostodMergeDaemon extends ActionVisitorTemplateMerge<BostodInfo, UserInfo> {
	
	public VisiBostodMergeDaemon(DeciTreeOption<BostodInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelectDaemon.class;
	}
	
	
	
	@Override protected List<BostodInfo> mergeHook(List<BostodInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return BostodMerger.mergeWithDaemon(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}

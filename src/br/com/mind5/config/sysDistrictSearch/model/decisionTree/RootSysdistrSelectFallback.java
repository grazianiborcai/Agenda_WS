package br.com.mind5.config.sysDistrictSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysDistrictSearch.model.action.LazySysdistrNodeSelectFallback;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSysdistrSelectFallback extends DeciTreeTemplateRead<SysdistrInfo> {
	
	public RootSysdistrSelectFallback(DeciTreeOption<SysdistrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysdistrInfo> buildCheckerHook(DeciTreeOption<SysdistrInfo> option) {
		List<ModelChecker<SysdistrInfo>> queue = new ArrayList<>();		
		ModelChecker<SysdistrInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysdistrInfo>> buildActionsOnPassedHook(DeciTreeOption<SysdistrInfo> option) {
		List<ActionStd<SysdistrInfo>> actions = new ArrayList<>();
		
		ActionStd<SysdistrInfo> select = new RootSysdistrSelect(option).toAction();
		ActionLazy<SysdistrInfo> nodeL1 = new LazySysdistrNodeSelectFallback(option.conn, option.schemaName);
		
		select.addPostAction(nodeL1);
		
		actions.add(select);
		return actions;
	}
}

package br.com.mind5.config.sysDistrictSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysDistrictSearch.model.action.StdSysdistrDaoSelect;
import br.com.mind5.config.sysDistrictSearch.model.checker.SysdistrCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSysdistrSelect extends DeciTreeTemplateRead<SysdistrInfo> {
	
	public RootSysdistrSelect(DeciTreeOption<SysdistrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysdistrInfo> buildCheckerHook(DeciTreeOption<SysdistrInfo> option) {
		List<ModelChecker<SysdistrInfo>> queue = new ArrayList<>();		
		ModelChecker<SysdistrInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysdistrCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysdistrInfo>> buildActionsOnPassedHook(DeciTreeOption<SysdistrInfo> option) {
		List<ActionStd<SysdistrInfo>> actions = new ArrayList<>();
		
		ActionStd<SysdistrInfo> select = new StdSysdistrDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}

package br.com.mind5.file.sysFileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysRootReplace;
import br.com.mind5.file.sysFileImage.model.action.StdFimgysMergeFimgysarchGroup;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckExistGroup;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeFimgysUpsertGroup extends DeciTreeTemplateWrite<FimgysInfo> {
	
	public NodeFimgysUpsertGroup(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgysInfo> buildCheckerHook(DeciTreeOption<FimgysInfo> option) {
		List<ModelChecker<FimgysInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgysInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new FimgysCheckExistGroup(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgysInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgysInfo> option) {
		List<ActionStd<FimgysInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgysInfo> insert = new RootFimgysInsert(option).toAction();
		
		actions.add(insert);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FimgysInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgysInfo> option) {
		List<ActionStd<FimgysInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgysInfo> mergeFimgysarch = new StdFimgysMergeFimgysarchGroup(option);
		ActionLazy<FimgysInfo> replace = new LazyFimgysRootReplace(option.conn, option.schemaName);
		
		mergeFimgysarch.addPostAction(replace);
		
		actions.add(mergeFimgysarch);		
		return actions;
	}
}

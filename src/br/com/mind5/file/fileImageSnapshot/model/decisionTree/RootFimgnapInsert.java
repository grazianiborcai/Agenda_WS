package br.com.mind5.file.fileImageSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.fileImageSnapshot.model.action.LazyFimgnapRootSelect;
import br.com.mind5.file.fileImageSnapshot.model.action.StdFimgnapDaoInsert;
import br.com.mind5.file.fileImageSnapshot.model.checker.FimgnapCheckInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootFimgnapInsert extends DeciTreeTemplateWrite<FimgnapInfo> {
	
	public RootFimgnapInsert(DeciTreeOption<FimgnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgnapInfo> buildCheckerHook(DeciTreeOption<FimgnapInfo> option) {
		List<ModelChecker<FimgnapInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgnapCheckInsert(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgnapInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgnapInfo> option) {
		List<ActionStd<FimgnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgnapInfo> insert = new StdFimgnapDaoInsert(option);
		ActionLazy<FimgnapInfo> select = new LazyFimgnapRootSelect(option.conn, option.schemaName);
		
		insert.addPostAction(select);

		actions.add(insert);		
		return actions;
	}
}

package br.com.mind5.file.sysFileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiRootSelect;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiWriteOnDisk;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckInsert;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckLangu;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckReference;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgysRootInsert extends DeciTreeTemplateWrite<FimgysInfo> {
	
	public FimgysRootInsert(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgysInfo> buildCheckerHook(DeciTreeOption<FimgysInfo> option) {
		List<ModelChecker<FimgysInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgysInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgysCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgysCheckReference(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgysCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgysInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgysInfo> option) {
		List<ActionStd<FimgysInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgysInfo> coverOff = new FimgysNodeCoverOffL1(option).toAction();
		ActionStd<FimgysInfo> insert = new FimgysNodeInsert(option).toAction();	
		ActionLazy<FimgysInfo> writeOnDisk = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiWriteOnDisk.class);
		ActionLazy<FimgysInfo> select = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiRootSelect.class);
		
		insert.addPostAction(writeOnDisk);
		writeOnDisk.addPostAction(select);
		
		actions.add(coverOff);
		actions.add(insert);	
		
		return actions;
	}
}

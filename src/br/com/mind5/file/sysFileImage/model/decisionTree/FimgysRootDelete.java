package br.com.mind5.file.sysFileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiDaoDelete;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiDaoUpdate;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceLChanged;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiMergeToUpdate;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckDelete;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgysRootDelete extends DeciTreeTemplateWrite<FimgysInfo> {
	
	public FimgysRootDelete(DeciTreeOption<FimgysInfo> option) {
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
		checker = new FimgysCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new FimgysCheckExist(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<FimgysInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgysInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgysInfo> option) {
		List<ActionStd<FimgysInfo>> actions = new ArrayList<>();
		
		ActionStd<FimgysInfo> mergeToUpdate = new ActionStdCommom<FimgysInfo>(option, FimgysVisiMergeToUpdate.class);	
		ActionLazy<FimgysInfo> enforceLChanged = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceLChanged.class);	
		ActionLazy<FimgysInfo> update = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiDaoUpdate.class);
		ActionLazy<FimgysInfo> delete = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiDaoDelete.class);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}

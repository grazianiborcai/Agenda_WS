package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.FimgVisiDaoDelete;
import br.com.mind5.file.fileImage.model.action.FimgVisiDaoUpdate;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeToUpdate;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeUsername;
import br.com.mind5.file.fileImage.model.checker.FimgCheckDelete;
import br.com.mind5.file.fileImage.model.checker.FimgCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgRootDelete extends DeciTreeTemplateWrite<FimgInfo> {
	
	public FimgRootDelete(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new FimgCheckExist(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<FimgInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();
		
		ActionStd<FimgInfo> mergeToUpdate = new ActionStdCommom<FimgInfo>(option, FimgVisiMergeToUpdate.class);	
		ActionLazy<FimgInfo> enforceLChanged = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceLChanged.class);	
		ActionLazy<FimgInfo> enforceLChangedBy = new ActionLazyCommom<FimgInfo>(option, FimgVisiMergeUsername.class);
		ActionLazy<FimgInfo> update = new ActionLazyCommom<FimgInfo>(option, FimgVisiDaoUpdate.class);
		ActionLazy<FimgInfo> delete = new ActionLazyCommom<FimgInfo>(option, FimgVisiDaoDelete.class);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}

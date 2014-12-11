package forum;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.omg.CORBA.IntHolder;
import org.omg.CORBA.StringHolder;

public class ForumImpl implements ForumAdminOperations,ForumOperations {

	private ConcurrentHashMap<String, Message> map;
	private String theme;
	private String moderator;


	public ForumImpl(String theme,String moderator) {
		this.theme = theme;
		this.moderator= moderator;
		map = new ConcurrentHashMap<>();
	}

	@Override
	public String theme() {
		return theme;
	}

	@Override
	public String moderator() {
		return moderator;
	}

	@Override
	public boolean postMessage(Message m) throws Reject {
		Message tmp = map.putIfAbsent(m.title, m);
		if(tmp != null){
			throw new Reject("title déja présent: " + m.title +" !!!!");
		}
		return true;
	}

	@Override
	public Message getMessage(String title) {
		return map.get(title);
	}

	@Override
	public boolean removeMessage(String title) throws Reject {
		if(title == null){
			return false;
		}else{
			if( map.remove(title) ==null){
				throw new Reject("Le message " + title + " n'existe pas");
			}
		}
		return true;
	}


@Override
public Message[] messageList() {
	return map.values().toArray(new Message[map.size()]);

}

@Override
public void getInfo(StringHolder theme, StringHolder moderator, IntHolder size) {
	theme.value = this.theme;
	moderator.value = this.moderator;
	size.value = map.size();
}

@Override
public void theme(String newTheme) {
	theme = newTheme;
	
}

@Override
public void moderator(String newModerator) {
	moderator = newModerator;
	
}




}

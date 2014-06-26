package Other;

public class TernaryTree
{
	private Node2 m_root = null;

	private void Add(String s, int pos, Node2 node)
	{
		if (node == null) 
		{ 
			node = new Node2(s.charAt(pos), false); 
		}

		if (s.charAt(pos) < node.m_char) 
		{
			Add(s, pos,  node.m_left); 
		}
		else if (s.charAt(pos) > node.m_char) 
		{
			Add(s, pos,  node.m_right); 
		}
		else
		{
			if (pos + 1 == s.length()) 
			{ 
				node.m_wordEnd = true; 
			}
			else 
			{ 
				Add(s, pos + 1,  node.m_center); 
			}
		}
	}

	public void Add(String s) throws Exception
	{
		if (s == null || s == "") throw new Exception();

		Add(s, 0,  m_root);
	}

	public boolean Contains(String s) throws Exception
	{
		if (s == null || s == "") throw new Exception();

		int pos = 0;
		Node2 node = m_root;
		while (node != null)
		{
			int cmp = s.charAt(pos) - node.m_char;
			if (s.charAt(pos) < node.m_char) 
			{ node = node.m_left; }
			else if (s.charAt(pos) > node.m_char) 
			{ node = node.m_right; }
			else
			{
				if (++pos == s.length()) return node.m_wordEnd;
				node = node.m_center;
			}
		}
		return false;
	}
}

class Node2
{
	char m_char;
	Node2 m_left, m_center, m_right;
	boolean m_wordEnd;

	public Node2(char ch, boolean wordEnd)
	{
		m_char = ch;
		m_wordEnd = wordEnd;
	}
}

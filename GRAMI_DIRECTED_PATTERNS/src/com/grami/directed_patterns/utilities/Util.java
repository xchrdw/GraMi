/**
 * Copyright 2014 Mohammed Elseidy, Ehab Abdelhamid

This file is part of Grami.

Grami is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 2 of the License, or
(at your option) any later version.

Grami is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with Grami.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.grami.directed_patterns.utilities;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import com.grami.directed_patterns.CSP.VariableCandidates;


public class Util 
{

	
	public static ArrayList<Integer> getIntersection(ArrayList<ArrayList<Integer>> sets)
	{
		ArrayList<Integer> inter= new ArrayList<Integer>();
		if(sets.size()==0)
			return inter;
		ArrayList<Integer> firstSet= sets.get(0);
		if(firstSet==null) return new ArrayList<Integer>();
		for (int i = 0; i < firstSet.size(); i++) 
		{
			int element=firstSet.get(i);
			boolean doesIntersect=true;
			for (int j = 1; j < sets.size(); j++) 
			{
				ArrayList<Integer> otherset=sets.get(j);
				if(otherset==null) return new ArrayList<Integer>();
				if(!otherset.contains(element))
				{
					doesIntersect=false;
					break;
				}
			}
			if(doesIntersect)
				inter.add(element);
		}
		return inter;
	}
	
	public static ArrayList<Integer> getIntersection(ArrayList<Integer> set1,ArrayList<Integer> set2)
	{
		ArrayList<Integer> inter= new ArrayList<Integer>();
		ArrayList<Integer> firstSet= set1;
		if(firstSet==null) return new ArrayList<Integer>();
		for (int i = 0; i < firstSet.size(); i++) 
		{
			int element=firstSet.get(i);
			if(set2.contains(element))
				inter.add(element);
		}
		return inter;
	}
	
	public static ArrayList<Point> getZerosIntersectionIndices(ArrayList<VariableCandidates > sets)
	{
		ArrayList<Point> points = new ArrayList<Point>();
		
		for (int i = 0; i < sets.size(); i++) 
		{
			VariableCandidates firstVariableCandidate=sets.get(i);
			ArrayList<Integer> firstElement=firstVariableCandidate.getCandidates();
			if(firstElement==null)continue;
			for (int j = i+1; j < sets.size(); j++) 
			{
				VariableCandidates secondVariableCandidate=sets.get(j);
				ArrayList<Integer> secondElement=secondVariableCandidate.getCandidates();
				if(secondElement==null)continue;
				boolean doesIntersect=false;
				for (int k = 0; k < firstElement.size(); k++) 
				{
					if(secondElement.contains(firstElement.get(k)))
					{doesIntersect=true; break;}
				}
				if(doesIntersect==false)
					points.add(new Point(firstVariableCandidate.getVariableID(),secondVariableCandidate.getVariableID()));
			}
		}
		return points;
	}
	
	public static  HashMap<Integer, HashSet<Integer>> clone(HashMap<Integer, HashSet<Integer>> in)
	{
		HashMap<Integer, HashSet<Integer>> out = new HashMap<Integer, HashSet<Integer>>();
		
		for (Iterator<Entry<Integer, HashSet<Integer>>> iterator = in.entrySet().iterator(); iterator.hasNext();) 
		{
			Entry<Integer, HashSet<Integer>> entry = iterator.next();
			out.put(entry.getKey(), (HashSet<Integer>)entry.getValue().clone());
		}
		
		return out;
	}
	
	
	
}

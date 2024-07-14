class Solution {
public:
    string countOfAtoms(string formula) {
        int n=formula.length();
        stack<unordered_map<string,int>>st;
        st.push(unordered_map<string,int>());
        int i=0;
        while(i<n){
            if(formula[i]=='('){
                st.push(unordered_map<string,int>());
                i++;
            }
            else if(formula[i]==')'){
                unordered_map<string,int>curr=st.top();
                st.pop();
                i++;

                string mult;
                while((i<n) and isdigit(formula[i])){
                    mult.push_back(formula[i]);
                    i++;
                }
                if(!mult.empty()){
                    int multInteger = stoi(mult);
                    for(auto &it : curr){
                        string element = it.first;
                        int count = it.second;
                        curr[element]=count*multInteger;
                    }
                }
                for(auto &it : curr){
                    string element = it.first;
                    int count = it.second;
                    st.top()[element]+=count;
                }
            }
            else{
                string CurrElement;
                CurrElement.push_back(formula[i]);
                i++;
                while(i<n && isalpha(formula[i]) && islower(formula[i])){
                    CurrElement.push_back(formula[i]);
                    i++;
                }
                string CurrCount;
                while(i<n && isdigit(formula[i])){
                    CurrCount.push_back(formula[i]);
                    i++;
                }
                int CurrCountInteger = CurrCount.empty() ? 1 : stoi(CurrCount);
                st.top()[CurrElement]+= CurrCountInteger;
            }
        }
        map<string ,int>SortedMap(begin(st.top()),end(st.top()));
        string result;

        for(auto &it : SortedMap){
            string element = it.first;
            result += element;

            int Count=it.second;
            if(Count>1){
                result+= to_string(Count);
            }
        }
        return result;
    }
};

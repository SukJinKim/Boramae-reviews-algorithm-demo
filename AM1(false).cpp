#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

string W, S;

bool match(int w, int s) {
    // 패턴과 문자열을 모두 소진한 경우
    if (w == W.size() && s == S.size()) return true;
    
    // 패턴은 남았지만 문자열을 모두 소진한 경우
    if (s == S.size()) {
        for (int i = w; i < W.size(); i++)
            if (W[i] != '*') return false;
        return true;
    }
    
    // 패턴을 모두 소진했지만 문자열이 남은 경우
    if (w == W.size()) return false;

    if (W[w] == '?' || W[w] == S[s]) {
        return match(w + 1, s + 1);
    }
    
    if (W[w] == '*') {
        // '*'가 0개 이상의 문자와 대응되는 모든 경우를 고려
        for (int skip = 0; skip <= S.size() - s; skip++) {
            if (match(w + 1, s + skip)) return true;
        }
    }
    
    return false;
}

void solve() {
    int c;
    cin >> c;
    for (int i = 0; i < c; i++) {
        vector<string> successCards;
        cin >> W;
        int n;
        cin >> n;
        for (int j = 0; j < n; j++) {
            cin >> S;
            if (match(0, 0)) successCards.push_back(S);
        }
        sort(successCards.begin(), successCards.end());
        for (auto& ele : successCards) 
            cout << ele << endl;
    }
}

int main() {
    solve();
    return 0;
}
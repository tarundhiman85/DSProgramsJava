dict={}
l = list(map(int,input().split()))
for i in range(len(l)):
    dict[l[i]]=i
nge=[-1]*len(l)
pse=[-1]*len(l)
st=[]
i=0
n=len(l)
#Next Greater Element
while i<n:
     if len(st)==0:
        st.append(l[i])
        i+=1
        continue
     while len(st)!=0 and st[len(st)-1]<l[i]:
        nge[dict[st[len(st)-1]]]=l[i]
        st.pop()
     if len(st)!=0 and st[len(st)-1]>l[i]:
        st.append(l[i])
        i+=1
for i in range(len(l)):
    print(nge[i])
#Previous Smaller Element
st.clear()
i=n-1
while i>0:
     if len(st)==0:
        st.append(l[i])
        i-=1
        continue
     while len(st)!=0 and st[len(st)-1]>l[i]:
        pse[dict[st[len(st)-1]]]=l[i]
        st.pop()
        
     if len(st)!=0 and st[len(st)-1]<l[i]:
        st.append(l[i])
        i-=1
        
        
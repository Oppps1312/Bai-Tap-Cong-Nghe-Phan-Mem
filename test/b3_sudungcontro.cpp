#include<iostream>
using namespace std;
void doicho(float *x, float *y)
{
	float z;
	z=*x;
	*x=*y;
	*y=z;
}

void khoitao(float *x, int n)
{
	for(int i=0;i<n;i++)
		*(x+i)=0;
}

void in(int *x,int n)
{
	for (int i=0;i<n;i++)
	cout<<*(x+i)<<" ";
}

int *nhonhat(int *a, int n)
{
	int min=*a;
	int *vitri=a;
	for (int i=0;i<n;i++)
		if (*(a+i)<=min)
		{
			min=*(a+i);
			vitri=a+i;
		}
	return vitri;
}
void saochep(int n, int *pa, int *pb)
{
	for(int i=0;i<n;i++)
		*(pb+i)=*(pa+i);
}
int main()
{
	float x,y;
	cout<<"X=";cin>>x;
	cout<<"Y=";cin>>y;
	doicho(&x,&y);
	cout<<x<<endl;
	cout<<y<<endl;
	int n;
	cout<<"Nhap so luong: ";cin>>n;
	float *a;
	a=new float[100];
	khoitao(a,n);
	cout<<"Khoi tao: ";
	if(a!=NULL)
	{
		for(int i=0;i<n;i++)
		cout<<*(a+i)<<" ";
	}
	int *pa,*pb;
	pa=new int[100];
	pb=new int[100];
	for(int i=0;i<n;i++)
		*(pa+i)=2;
	saochep(n,pa,pb);
	cout<<"\nSao chep: ";
	if(pb!=NULL)
	{
		in(pa,n);
		in(pb,n);
	}
//////////////////////////////////////"
	int *z;
	z=new int[100];
	for(int i=0;i<n;i++)
		*(z+i)=i;
	cout<<"\n"<<nhonhat(z,n);
}
/*int main()
{
	int a=4;
	int *q=&a;
	cout<<q<<endl;
	cout<<*q;
}*/

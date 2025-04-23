export interface PostCard {
  id: number;
  user: {
    alias: string;
    profilPictureUrl?: string;
  }
  description: string;
  createdAt: number;
}
